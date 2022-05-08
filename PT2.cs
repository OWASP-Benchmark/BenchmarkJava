using System;
using System.IO;
using Microsoft.AspNetCore.Mvc;

namespace WebFox.Controllers.PathTraversal
{
    public class PathTraversalTest2 : ControllerBase
    {
        private const string RootFolder = @"C:\Temp\Data\";

        [HttpGet("{userInput}")]
        public void Test(string userInput)    
        {    
            try
            {
                var fullPath = Path.Combine(RootFolder, userInput);
                System.IO.File.Delete(fullPath);
            }    
            catch (IOException ioExp)    
            {    
                Console.WriteLine(ioExp.Message);    
            }
            Console.ReadKey();    
        }
    }
}