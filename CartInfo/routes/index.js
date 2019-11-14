var express = require('express');
var router = express.Router();
var apiVersion1 = "/api/v1/";
var logger = require('../util/logger');
var mongo = require('../service/mongodb');
var request = require('request');

var apiGetCartInfo = apiVersion1+"cart";
var apiGetTest = apiVersion1+"test";
var clusterDomain = ".svc.cluster.local";

router.get(apiGetCartInfo,(req,res) => {

  logger.info("GET "+apiGetCartInfo);
  if (!req.query.userId) {
    res.status(400).json({
      "error_code": "400",
      "message" : "cant not found params."
    });
  }else {

    mongo.getProductsFromCart(req.query.userId)
    .then(async (data) => {
      res.json(data);
    })
    .catch( (e)=> {
      logger.error(e);
      res.status(500).json({
        "error_code" : 1,
        "message" : e
      });
    })
  }

  
});


router.get(apiGetTest, (req,res) => {
  
  var host =  getTestHost();
  logger.info("host->"+host);
  request.get("http://"+host+"/userinfo/all",(err,response,body) => {
    if(err) {
      logger.error(err);
      res.status(500).json({
        "error_code" : 500,
        "message": "user info is not accessable"
      });
    }else {
      logger.info(body);
      res.json(body);
    }
    
  });
});

var getTestHost  = () => {
  var serviceName = process.env.USERINFO_SERVICE_NAME;
  var namespace = process.env.USERINFO_NAMESPACE;
  
 return serviceName+"."+namespace+clusterDomain;
}

module.exports = router;