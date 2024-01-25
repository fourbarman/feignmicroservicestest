# Spring synchronous microservice interaction

### Used tools

- SpringBoot 2.7.12
- Spring Data JPA
- Spring Web
- RestTemplate
- OpenFeign
- WebClient
- Swagger
- H2 database
- Lombock

### How to use:
First, start Source service (port:8080). It creates inmemory DB called "items". You can control it with H2Console (db path " jdbc:h2:mem:items")

Then start other services to create\update\delete\find items:
- RestTemplate service (port:8081)
- OpenFeign service (port:8082)
- WebClient service (port:8083)

You can use Swagger to get endpoints or import to Postman.


Example:
<details>
<summary>api on localhost:8080</summary>
{"openapi":"3.0.1","info":{"title":"OpenAPI definition","version":"v0"},"servers":[{"url":"http://localhost:8080","description":"Generated server url"}],"paths":{"/api/item":{"put":{"tags":["tracker-controller"],"operationId":"update","parameters":[{"name":"id","in":"query","required":true,"schema":{"type":"integer","format":"int32"}}],"requestBody":{"content":{"application/json":{"schema":{"$ref":"#/components/schemas/Item"}}},"required":true},"responses":{"200":{"description":"OK","content":{"*/*":{"schema":{"type":"string","enum":["100 CONTINUE","101 SWITCHING_PROTOCOLS","102 PROCESSING","103 CHECKPOINT","200 OK","201 CREATED","202 ACCEPTED","203 NON_AUTHORITATIVE_INFORMATION","204 NO_CONTENT","205 RESET_CONTENT","206 PARTIAL_CONTENT","207 MULTI_STATUS","208 ALREADY_REPORTED","226 IM_USED","300 MULTIPLE_CHOICES","301 MOVED_PERMANENTLY","302 FOUND","302 MOVED_TEMPORARILY","303 SEE_OTHER","304 NOT_MODIFIED","305 USE_PROXY","307 TEMPORARY_REDIRECT","308 PERMANENT_REDIRECT","400 BAD_REQUEST","401 UNAUTHORIZED","402 PAYMENT_REQUIRED","403 FORBIDDEN","404 NOT_FOUND","405 METHOD_NOT_ALLOWED","406 NOT_ACCEPTABLE","407 PROXY_AUTHENTICATION_REQUIRED","408 REQUEST_TIMEOUT","409 CONFLICT","410 GONE","411 LENGTH_REQUIRED","412 PRECONDITION_FAILED","413 PAYLOAD_TOO_LARGE","413 REQUEST_ENTITY_TOO_LARGE","414 URI_TOO_LONG","414 REQUEST_URI_TOO_LONG","415 UNSUPPORTED_MEDIA_TYPE","416 REQUESTED_RANGE_NOT_SATISFIABLE","417 EXPECTATION_FAILED","418 I_AM_A_TEAPOT","419 INSUFFICIENT_SPACE_ON_RESOURCE","420 METHOD_FAILURE","421 DESTINATION_LOCKED","422 UNPROCESSABLE_ENTITY","423 LOCKED","424 FAILED_DEPENDENCY","425 TOO_EARLY","426 UPGRADE_REQUIRED","428 PRECONDITION_REQUIRED","429 TOO_MANY_REQUESTS","431 REQUEST_HEADER_FIELDS_TOO_LARGE","451 UNAVAILABLE_FOR_LEGAL_REASONS","500 INTERNAL_SERVER_ERROR","501 NOT_IMPLEMENTED","502 BAD_GATEWAY","503 SERVICE_UNAVAILABLE","504 GATEWAY_TIMEOUT","505 HTTP_VERSION_NOT_SUPPORTED","506 VARIANT_ALSO_NEGOTIATES","507 INSUFFICIENT_STORAGE","508 LOOP_DETECTED","509 BANDWIDTH_LIMIT_EXCEEDED","510 NOT_EXTENDED","511 NETWORK_AUTHENTICATION_REQUIRED"]}}}}}},"post":{"tags":["tracker-controller"],"operationId":"save","requestBody":{"content":{"application/json":{"schema":{"$ref":"#/components/schemas/Item"}}},"required":true},"responses":{"200":{"description":"OK","content":{"*/*":{"schema":{"$ref":"#/components/schemas/Item"}}}}}},"delete":{"tags":["tracker-controller"],"operationId":"delete","parameters":[{"name":"id","in":"query","required":true,"schema":{"type":"integer","format":"int32"}}],"responses":{"204":{"description":"No Content"}}}},"/api/item/getByName":{"get":{"tags":["tracker-controller"],"operationId":"getByName","parameters":[{"name":"name","in":"query","required":true,"schema":{"type":"string"}}],"responses":{"200":{"description":"OK","content":{"*/*":{"schema":{"type":"array","items":{"$ref":"#/components/schemas/Item"}}}}}}}},"/api/item/getById":{"get":{"tags":["tracker-controller"],"operationId":"getById","parameters":[{"name":"id","in":"query","required":true,"schema":{"type":"integer","format":"int32"}}],"responses":{"200":{"description":"OK","content":{"*/*":{"schema":{"$ref":"#/components/schemas/Item"}}}}}}},"/api/item/getAll":{"get":{"tags":["tracker-controller"],"operationId":"getAll","responses":{"200":{"description":"OK","content":{"*/*":{"schema":{"type":"array","items":{"$ref":"#/components/schemas/Item"}}}}}}}}},"components":{"schemas":{"Item":{"type":"object","properties":{"id":{"type":"integer","format":"int32"},"name":{"type":"string"}}}}}}
</details>