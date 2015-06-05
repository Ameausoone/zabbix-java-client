#launch zabbix docker container
docker run -d -p 10051:10051 -p 10052:10052 -p 80:80 -p 2812:2812 --name zabbix berngp/docker-zabbix

#list images
docker images

#launch existing images
docker run -d -p 10051:10051 -p 10052:10052 -p 80:80 -p 2812:2812 -t 2f55e99d5273