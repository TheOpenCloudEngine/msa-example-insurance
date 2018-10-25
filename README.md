```bash

http localhost:9991/credits ssn="770921" creditRate="C"
http "http://localhost:9991/customers" name="장진영" ssn="770921"
http PATCH localhost:9991/credits/770921 creditRate="A"
http "http://localhost:9991/customers" name="장진영" ssn="770921"

http "http://localhost:9991/vehicles" modelName="BMW7" id="1111-1111" owner="http://localhost:9991/customers/1"
http  "http://localhost:9991/vehicles/1111-1111/owner"
http "http://localhost:9991/customers/1/vehicles"


```# sw-modeling-example-monolith-to-msa
