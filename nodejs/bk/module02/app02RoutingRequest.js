const http = require("http");

const server = http.createServer((req, res) => {
  var url = req.url;

  console.log(url);
  if (url === "/") {
    res.setHeader("Content-Type", "text/html");
    res.write("<html>");
    res.write("<header><title>Enter Message</title></header>");
    res.write("<body>" +
      "<form action='/message' method='POST'>" +
      "<input type='text' name='message'/>" +
      "<button type='submit'>Submit</button>" +
      "</form>" +
      "</body>");
    res.write("</html>");
    return res.end();
  }
  res.setHeader("Content-Type", "text/html");
  res.write("<html>");
  res.write("<header><title>First Nodejs Page</title></header>");
  res.write("<body><h1>Hello from my Node.js Server!</h1></body>");
  res.write("</html>");
  res.end();
  //process.exit();
});

server.listen(3000);