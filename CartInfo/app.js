var createError = require('http-errors');
var express = require('express');
var bodyParser = require('body-parser');
var index = require("./routes/index")
var path = require('path');
var app = express();
var logger = require('./util/logger');

app.use(bodyParser.json());
app.use(express.json());
app.use("/",index);

app.use(function(req, res, next) {
  next(createError(404));
});

// error handler
app.use(function(err, req, res, next) {
  // set locals, only providing error in development
  res.locals.message = err.message;
  res.locals.error = req.app.get('env') === 'development' ? err : {};
  logger.error("error" + err.message);
  // render the error page
  res.status(err.status || 500);
  res.render('error');
});



module.exports = app;