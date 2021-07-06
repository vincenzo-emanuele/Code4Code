const jsdom = require("jsdom");
const { JSDOM } = jsdom;
const fs = require('fs');

(async () => {
  fs.readFile('./topics.html', 'utf8', function (err,data) {
    if (err) {
      return console.log(err);
    }
    const dom = new JSDOM(data);
    console.log(dom.window.document.querySelectorAll('p.f3').forEach(title => (fs.appendFile("corpus.cor", title.parentNode.querySelector("p.f5").innerHTML.trim() + "\n", "utf-8", function(err, data){
      if(err){
        return console.log(err);
      }
    }))));
  });
})()