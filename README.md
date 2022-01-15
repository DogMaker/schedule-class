# Request
```console
curl --location --request POST 'http://0.0.0.0:8080//create-range' \
--header 'Content-Type: application/json' \
--data-raw '{
"eventType":"FREE",
"start":"2011-12-03T10:15:30",
"end":"2011-12-04T09:15:30",
"exceptDays":["SUNDAY"],
"exceptTimes":["2011-12-03T10:15:30"]
}'
```