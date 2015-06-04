package com.github.zabbixjavaclient.converter;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

import lombok.extern.slf4j.Slf4j;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.google.common.collect.Maps;

@Slf4j
public class MacroDeserializer extends StdDeserializer<Map<String, String>> {

    public MacroDeserializer() {
        super(Map.class);
    }

    protected MacroDeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public Map<String, String> deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        ObjectMapper mapper = (ObjectMapper) jp.getCodec();
        ArrayNode array = (ArrayNode) mapper.readValue(jp, ArrayNode.class);
        Map<String, String> macros = Maps.newHashMap();
        for (Iterator<JsonNode> iterator = array.iterator(); iterator.hasNext();) {
            JsonNode node = iterator.next();
            macros.put(node.get("macro").asText(), node.get("value").asText());
        }
        return macros;
    }
}
