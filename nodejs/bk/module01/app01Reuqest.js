const http = require("http");

const server = http.createServer((req, res) => {
  console.log("this is the request: " + req);
  res.setHeader("Content-Type", "text/html");
  res.write("<html>");
  res.write("<header><title>First Nodejs Page</title></header>");
  res.write("<body><h1>Hello from my Node.js Server!</h1></body>");
  res.write("</html>");
  res.end();
  //process.exit();
});

server.listen(3000);