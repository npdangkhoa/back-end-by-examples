const fs = require('fs');


const requestHandler = (req, res) => {
    var url = req.url;
    const method = req.method;
    console.log("URL: " + url);
    console.log("Method: " + method);

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

    if (url === '/message' && method === 'POST') {
        const body = []
        req.on('data', (chuck) => {
            console.log(chuck);
            body.push(chuck);
            console.log(body.toString);
        });

        req.on('end', () => {
            const newLocal = Buffer.concat(body).toString();
            console.log('body=' + newLocal);
            const message = newLocal.split('=')[1];
            fs.writeFileSync('message.txt', message);
            res.statusCode = 302;
            res.setHeader('Location', '/');
            console.log();
            return res.end();
        });
    }


    //res.setHeader("Content-Type", "text/html");
    res.write("<html>");
    res.write("<header><title>First Nodejs Page</title></header>");
    res.write("<body><h1>Hello from my Node.js Server!</h1></body>");
    res.write("</html>");
    res.end();
    //process.exit();
}

module.exports = {
    handler: requestHandler,
    someText: 'some hard coded'
}