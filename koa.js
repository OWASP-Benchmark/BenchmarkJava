
const Koa = require('koa');
const urlLib = require('url');
const app = new Koa();

app.use(async ctx => {
	var url = ctx.query.target;
	ctx.redirect(url); 
});

app.listen(3000);