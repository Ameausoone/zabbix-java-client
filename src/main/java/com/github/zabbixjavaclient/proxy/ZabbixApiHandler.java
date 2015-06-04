package com.github.zabbixjavaclient.proxy;

import static com.google.common.base.Preconditions.checkState;
import static com.google.common.collect.Lists.newArrayList;
import static org.apache.commons.lang3.StringUtils.isNotBlank;
import static org.apache.commons.lang3.StringUtils.removeEnd;
import static org.apache.commons.lang3.StringUtils.splitByCharacterTypeCamelCase;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import lombok.extern.slf4j.Slf4j;

import org.apache.commons.lang3.StringUtils;

import com.github.zabbixjavaclient.bean.Result;
import com.github.zabbixjavaclient.bean.get.Get;
import com.github.zabbixjavaclient.ex.ZbxApiException;
import com.googlecode.jsonrpc4j.JsonRpcHttpClient;

@Slf4j
public class ZabbixApiHandler implements InvocationHandler {

	private final JsonRpcHttpClient rpcClient;

	public ZabbixApiHandler(JsonRpcHttpClient client) {
		this.rpcClient = client;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		log.debug("proxy : [{}], method :[{}]", proxy, method);
		log.debug("args : [{}]", args);
		String[] splitByCharacterTypeCamelCase = splitByCharacterTypeCamelCase(method.getName());
		String action = splitByCharacterTypeCamelCase[0];
		Optional<String> elementType = Optional.empty();

		if (splitByCharacterTypeCamelCase.length == 2) {
			String element = splitByCharacterTypeCamelCase[1].toLowerCase();
			element = StringUtils.removeEnd(element, "s");
			elementType = Optional.of(element);
		}

		boolean isReturnOptional = method.getReturnType().equals(Optional.class);
		switch (action) {
		case "logout":
			return logout();
		case "get":
			if (isReturnOptional) {
				return getElements((Get) args[0]).stream().findFirst();
			} else {
				return getElements((Get) args[0]);
			}
		case "create":
			if (isReturnOptional) {
				return createElement(args[0], elementType.get());
			} else {
				return createElements((List) args[0], elementType.get());
			}
		case "delete":
			if (isReturnOptional) {
				return deleteElement((Integer) args[0], elementType.get());
			} else {
				return deleteElements((List<Integer>) args[0], elementType.get());
			}
		case "update":
			if (isReturnOptional) {
				return updateElement(args[0], elementType.get());
			}
			break;
		case "to":
			break;
		default:
			throw new ZbxApiException("Insupported method : " + action);
		}
		return null;
	}

	private Boolean logout() {
		try {
			return rpcClient.invoke("user.logout", null, Boolean.class);
		} catch (Throwable e) {
			throw new ZbxApiException("Error during logout", e);
		}
	}

	protected <T, U> List<T> getElements(Get<T, U> getParams) {
		log.debug("getParams : [{}]", getParams);
		List<T> elements = null;
		try {
			String elementType = getParams.getClass().getSimpleName();
			elementType = removeEnd(elementType, "Get").toLowerCase();
			Class<List<T>> listClass = getParams.getListClass();
			elements = rpcClient.invoke(elementType + ".get", getParams, listClass);
		} catch (Throwable e) {
			throw new ZbxApiException("Error during get elements with params:[" + getParams + "]", e);
		}
		return elements;
	}

	private Optional<Integer> createElement(Object element, String elementType) {
		return createElements(newArrayList(element), elementType).stream().findFirst();
	}

	private <T> List<Integer> createElements(List<T> elements, String elementType) {
		validateBeans(elements);
		Result response = null;
		try {
			response = rpcClient.invoke(elementType + ".create", elements, Result.class);
		} catch (Throwable e) {
			throw new ZbxApiException("Error during " + elementType + " creation for elements :[" + elements + "]", e);
		}
		List<Integer> ids = response.values().stream().findFirst().get();
		return ids;
	}

	private <T> void validateBeans(List<T> beans) {
		for (T bean : beans) {
			validateBean(bean);
		}
	}

	private <T> void validateBean(T bean) {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();
		Set<ConstraintViolation<T>> constraintViolations = validator.validate(bean);
		if (!constraintViolations.isEmpty()) {
			StringBuilder builder = new StringBuilder();
			for (ConstraintViolation<T> constraint : constraintViolations) {
				builder.append("[property : \"").append(constraint.getPropertyPath()).append("\" ")
						.append(constraint.getMessage()).append("],");
			}
			builder.deleteCharAt(builder.length() - 1);
			throw new ZbxApiException("Error during create elements, informations are not valid, element to create : ["
					+ bean.toString() + "], violations : [" + builder.toString() + "]");
		}
	}

	private Optional<Integer> deleteElement(Integer id, String type) {
		return deleteElements(newArrayList(id), type).stream().findFirst();
	}

	private List<Integer> deleteElements(List<Integer> ids, String type) {
		checkState(ids != null && !ids.isEmpty(), "ids for " + type + " should not be null or empty");
		checkState(isNotBlank(type));
		Result response = null;
		try {
			response = rpcClient.invoke(type + ".delete", ids, Result.class);
		} catch (Throwable e) {
			throw new ZbxApiException("Error during delete " + type + " for ids :[" + ids + "]", e);
		}
		List<Integer> deletedIds = response.values().stream().findFirst().get();
		return deletedIds;
	}

	private Optional<Integer> updateElement(Object element, String elementType) {
		return updateElements(newArrayList(element), elementType).stream().findFirst();
	}

	private <T> List<Integer> updateElements(List<T> elements, String elementType) {
		Result response = null;
		try {
			response = rpcClient.invoke(elementType + ".update", elements, Result.class);
		} catch (Throwable e) {
			throw new ZbxApiException("Error during " + elementType + " creation for elements :[" + elements + "]", e);
		}
		List<Integer> ids = response.values().stream().findFirst().get();
		return ids;
	}

}
