
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using System.Web;

namespace WebFox.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class XSS : ControllerBase
    {
        public async void xss(string userInfo)
        {
            var context = this.ControllerContext.HttpContext;

            await context.Response.WriteAsync("<body>"+ userInfo +"</body>");

        }
    }
}
