using Microsoft.AspNetCore.Mvc;

namespace WebFox.Controllers.PathTraversal
{
    public class PathTraversalTest1 : ControllerBase
    {
        [HttpGet("{path}")]
        public void Test(string path)
        {
            System.IO.File.Delete(path);
        }


    }
}