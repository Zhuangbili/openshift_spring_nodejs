module.exports = (function(){

  var log4js = require('log4js');
  var loggerConfigfile = require('../config/log4js_config.json');
  const loggerConfig = loggerConfigfile["logConfigure"];
      log4js.configure(loggerConfig, { cwd: 'server/logs' });

      var accessLog = log4js.getLogger('access');
      var errorLog = log4js.getLogger('error');

      /**
       * export Services 
       */
      return {
              access : accessLog,
              fatal  : function(msg){
                      errorLog.fatal(msg);
              },
              error  : function(msg){
                      errorLog.error(msg);
              },
              warn   : function(msg){
                      errorLog.warn(msg);
              },
              info   : function(msg){
                      accessLog.info(msg);
              },
              debug  : function(msg){
                      accessLog.debug(msg);
              },
              trace  : function(msg){
                      accessLog.trace(msg);
              }
      };
})();