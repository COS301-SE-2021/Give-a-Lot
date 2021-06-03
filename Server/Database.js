const { Client } = require('pg')

const client = new Client({
    host:"localhost",
    port:5432,
    user:"postgres",
    password: "password",
    database: "Give A Lot"
})

client.connect()
.then(()=>console.log("connected succesfully"))
    .then(()=> client.query("select * from users"))
    .then(results => console.table(results.rows))
    .catch(e=> console.log())
    .finally(()=>client.end())
