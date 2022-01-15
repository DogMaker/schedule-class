# Request
```console
curl --location --request POST 'http://0.0.0.0:8080//create-range' \
--header 'Content-Type: application/json' \
--data-raw '{
	"eventType": "FREE",
	"start": "2022-01-15T10:00:00",
	"end": "2022-01-15T18:00:00",
	"exceptDays": ["FRIDAY"],
	"exceptTimes": [{
		"start": "11:59",
		"end": "14:00"
	}]
}'
```