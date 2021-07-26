const jsdom = require("jsdom");
const { JSDOM } = jsdom;
const fs = require('fs');
//let frameworks = ["ajax", "amp", "android", "angular", "aspdotnet", "bootstrap", "csharp", "django", "dotnet", "electron", "express", "firebase", "flask", "java", "javascript", "jquery", "keras", "koa", "laravel", "nativescript", "node", "rails", "ratchet", "react", "reactiveui", "scikit", "spring", "symfony", "tensorflow", "thymeleaf", "vue"]
let frameworks = ["javascript"]
frameworks.forEach(element => {
    (async () => {
        fs.readFile('./' + element + '.html', 'utf8', function (err,data) {
          if (err) {
            return console.log(err);
          }
          const dom = new JSDOM(data);
          dom.window.document.querySelectorAll('article').forEach(function(article) {
              let topic_tags = article.querySelectorAll('a.topic-tag');
              if(topic_tags.length != 0){
                  let tags = element + " ";
                  topic_tags.forEach(function(tag){
                      tags += tag.innerHTML.trim() + " ";
                  })
                  tags += "\n";
                  fs.appendFile("tags.cor", tags, "utf-8", function(err, data){
                      if(err){
                          console.log(err);
                      }
                  })
              }
          })
          });
      })()
});
