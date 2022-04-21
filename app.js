const express = require('express');
const routes = require('./routes');
const hbs = require('express-handlebars');
const app = express();

app.use(routes);
app.use(express.static(__dirname + '/public'));
app.engine('handlebars', hbs.engine());
app.set('view engine', 'handlebars');
app.set('views', './views');


app.listen(5000,function(){
    console.log('Server is running at 5000 port')

})