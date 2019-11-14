var MongoClient = require('mongodb').MongoClient;
var db;

var mongo_host = process.env.MONGODB_SERVICE_HOST;
var mongo_port = process.env.MONGODB_SERVICE_PORT;
var mongo_user = process.env.MONGO_USER_NAME;
var mongo_password = process.env.MONGO_USER_PASSWORD;
var mongo_database = process.env.MONGO_DATABASE_NAME;
var mongo_collection = process.env.MONGO_COLLECTION;

var url = "mongodb://"+mongo_user+":"+mongo_password+"@"+mongo_host+":"+mongo_port+"/"+mongo_database;

var logger = require('../util/logger');

MongoClient.connect(url,{ useNewUrlParser: true,autoReconnect : true }).then(client => {
  logger.info("Connected successfully to server");
  db = client.db(mongo_database);
}).catch(err => {
  logger.error(err);
});

exports.getProductsFromCart = async (userId) => {
  var collection = db.collection(mongo_collection);
  var result = await collection.find({"custom_id":userId}).toArray();
  logger.info(result);
  return result;
}

