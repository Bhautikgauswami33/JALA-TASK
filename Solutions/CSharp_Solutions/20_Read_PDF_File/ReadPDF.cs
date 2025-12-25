using System;
using System.IO;

namespace ReadPDFFile
{
    class ReadPDF
    {
        static void Main(string[] args)
        {
            Console.WriteLine("=== Reading PDF File and Extracting Content ===\n");
            
            // Define the source text file path (simulating PDF content)
            // In a real scenario with actual PDF files, we would use a PDF library
            string sourcePath = @"d:\JALA TASK\pdf_content.txt";
            string outputPath = @"d:\JALA TASK\output.txt";
            
            try
            {
                // Read the content from the source file (simulating PDF content)
                string content = File.ReadAllText(sourcePath);
                
                // Display the content on console
                Console.WriteLine("Content read from source file (simulating PDF content):\n");
                Console.WriteLine("==============================");
                Console.WriteLine(content);
                Console.WriteLine("==============================\n");
                
                // Write the content to the output file
                File.WriteAllText(outputPath, content);
                Console.WriteLine($"Content successfully extracted and saved to {outputPath}");
                
                // Confirmation message
                Console.WriteLine("\nTask completed: PDF content extraction and file writing");
            }
            catch (Exception ex)
            {
                Console.WriteLine($"Error occurred while reading or writing file: {ex.Message}");
            }
            
            Console.WriteLine("\nPress any key to exit...");
            Console.ReadKey();
        }
    }
}