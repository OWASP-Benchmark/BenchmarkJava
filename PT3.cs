
using System.IO;
using Microsoft.AspNetCore.Mvc;

namespace WebFox.Controllers.PathTraversal
{
    public class PathTraversalTest3 : ControllerBase
    {
        private const string RootFolder = @"C:\Temp\Data\"; 
        
        [HttpGet("{userInput}")]
        public void Test(string userInput)    
        {
            string[] lines = { "First line", "Second line", "Third line" };
            using (var outputFile = new StreamWriter(RootFolder + userInput))
            {
                foreach (var line in lines)
                    outputFile.WriteLine(line);
            }
        }
    }
}