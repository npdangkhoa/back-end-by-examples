const fs = require("fs");

const requestHandler = (request, response) => {
  var url = request.url;
  const method = request.method;
  console.log("URL: " + url);
  console.log("Method: " + method);

  if (url === "/") {
    response.setHeader("Content-Type", "text/html");
    response.write("<html>");
    response.write("<header><title>Enter Message</title></header>");
    response.write(
      "<body>" +
      "<form action='/message' method='POST'>" +
      "<input type='text' name='message'/>" +
      "<button type='submit'>Submit</button>" +
      "</form>" +
      "</body>"
    );
    response.write("</html>");

    return response.end();
  }

  if (url === "/message" && method === "POST") {
    const body = [];
    request.on("data", chuck => {
      console.log(chuck);
      body.push(chuck);
      console.log(body.toString);
    });

    return request.on("end", () => {
      const newLocal = Buffer.concat(body).toString();
      console.log("body=" + newLocal);
      const message = newLocal.split("=")[1];
      fs.writeFile("message.txt", message, err => {
        response.statusCode = 302;
        response.setHeader("Location", "/");
        console.log("err:" + err);
        return response.end();
      });
    });
  }

  response.setHeader("Content-Type", "text/html");
  response.write("<html>");
  response.write("<head><title>First Nodejs Page</title></head>");
  response.write("<body><h1>Hello from my Node.js Server!</h1></body>");
  response.write("</html>");
  response.end();
};

module.exports = {
  handler: requestHandler,
  someText: "some hard coded"
};