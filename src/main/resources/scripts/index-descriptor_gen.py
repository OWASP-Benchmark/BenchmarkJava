#! /usr/bin/python

# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.

__author__ = "iammyr"
__date__ = "$17-Jun-2015 14:40:15$"

import os
from const import CONST
import argparse

'''
Extracts all the .class files from a directory and its sub-directories recursively.
@param root absolute path of a directory from which to start to traverse
@return: list of .class file names
'''
def recursive_dir_traversal(rootDir):
    file_names = []
    for root, subDirList, files in os.walk(rootDir):
        for filename in files:
            if filename.endswith((".java")):
                file_names.append(filename[:-5])
    return file_names


def createIndexHtml(tot_tests):
    content = CONST.HTML_START 
    for ind in range(1, tot_tests):
        content += CONST.LIST_ITEM_START1 + str(ind) + CONST.LIST_ITEM_START2 + \
        "Benchmark " + str(ind) + CONST.LIST_ITEM_END
    content += CONST.HTML_END
    return content
    
def saveToFile(content, filename):
    # print "writing to " + filename
    # print "the content:\n" + content
    with open(filename, 'w') as file_:
        file_.write(content)
        
def createDescriptorXml(tests):
    content = CONST.XML_START
    ind = 1
    for name in tests:
        content += CONST.SERVLET_XML_START1 + str(ind) + \
        CONST.SERVLET_XML_START2 + name + CONST.SERVLET_XML_START3 + str(ind) + \
        CONST.SERVLET_XML_START4 + str(ind) + CONST.SERVLET_XML_START5
        ind += 1
    content += CONST.XML_END
    return content


if __name__ == "__main__":
    args_parser = argparse.ArgumentParser()
    args_parser.add_argument("-md", "--maindir", required=True, dest="main_dir")
    args = args_parser.parse_args()

    tests = recursive_dir_traversal(args.main_dir + '/src/main/java/org/owasp/webgoat/benchmark/testcode/')
    print createIndexHtml(len(tests))
    saveToFile(createIndexHtml(len(tests)), args.main_dir + '/src/main/webapp/WEB-INF/index.html')
    print createDescriptorXml(tests)
    saveToFile(createDescriptorXml(tests), args.main_dir + '/src/main/webapp/WEB-INF/web.xml')
    
    
    
