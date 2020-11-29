var mysql = require('mysql');
var bodyParser = require('body-parser')

const express        = require('express');
const port = 8000;
const app            = express();
app.use( bodyParser.json() );       // to support JSON-encoded bodies
app.use(bodyParser.urlencoded({     // to support URL-encoded bodies
  extended: true
})); 
var con = mysql.createConnection({
  host: "localhost",
  user: "root",
  password: "",
  database:"mydb"
});

con.connect(function(err) {
 console.log("Connected");

  
});


app.post('/checkUser', (req, res) => {   
    res.send("ASds");
  });
app.post('/createUser', (req, res) => {   
    
      let data = {firstname: req.body.firstname, lastname: req.body.lastname,email: req.body.email, password: req.body.password,address: req.body.address};

    let sql = "INSERT INTO users SET ?";
    let query = con.query(sql, data,(err, results) => {
      if(err){
        res.setHeader('Content-Type', 'application/json');
        res.end(JSON.stringify({ "message": err,"res":"failed" }));
      }else{
        res.setHeader('Content-Type', 'application/json');
        res.end(JSON.stringify({ "message": "user added","res":"success" }));
      }
       
      
    });
        
  });

  app.post('/authenticateUser', (req, res) => {   
    let sql = "SELECT * FROM users WHERE email='"+req.body.email+"' AND password='"+req.body.password+"'";
    console.log(req);
  let query = con.query(sql, (err, results) => {
    numRows = results.length;
    if(numRows==1){
        res.setHeader('Content-Type', 'application/json');
        res.end(JSON.stringify({ "message": "User authenticated","res":"success" }));
    }else{
        res.setHeader('Content-Type', 'application/json');
        res.end(JSON.stringify({ "message": "User Authentication Failed","res":"failed" }));
    }
  });
        
  });
  
  app.post('/products', (req, res) => {   
    let sql = "SELECT * FROM products";
  let query = con.query(sql, (err, results) => {
      console.log(results.length);
      res.setHeader('Content-Type', 'application/json');
      if(results.length !=0){

        var json = JSON.stringify({ 
            "res": "success", 
            "data": results, 
            "message": "data Received"
          });
          res.end(json);
      }else{
        var json = JSON.stringify({ 
            "res": "failed", 
            "data": results, 
            "message": "No data Received"
          });
          res.end(json);
      }
    
  });
        
  });

  app.post('/placeOder', (req, res) => {   
    
      let data = {email: req.body.email, productid: req.body.productid};

    let sql = "INSERT INTO orders SET ?";
    let query = con.query(sql, data,(err, results) => {
      if(err){
        
        res.send("Error");
      }else{
        res.send("Order Placed");
      }
       
      
    });
        
  });


  
app.listen(port, () => {  console.log('We are live on ' + port);});
