#! /usr/bin/python

# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.

__author__ = "iammyr"
__date__ = "$17-Jun-2015 16:02:52$"
'''
Created on 13 Apr 2015

@author: iammyr
'''


def constant(f):
    def fset(self, value):
        raise SyntaxError
    def fget(self):
        return f()
    return property(fget, fset)

class _Const(object):
    @constant
    def HTML_START():
        return '<!DOCTYPE html><html> <head><title>OWASP WebGoat Benchmark</title> \
    <meta charset="UTF-8"><meta name="viewport" content="width=device-width, initial-scale=1.0"> \
    </head><body><div><ul>'
    @constant
    def HTML_END():
        return '</ul></div></body></html>'
    @constant
    def LIST_ITEM_START1():
        return '<li><a href="'
    @constant
    def LIST_ITEM_START2():
        return '">'
    @constant
    def LIST_ITEM_END():
        return '</a></li>'
    @constant
    def XML_START():
        return '<?xml version="1.0" encoding="UTF-8"?> \
         <web-app version="2.4" xmlns="http://java.sun.com/xml/ns/j2ee" \
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" \
         xsi:schemaLocation="http://java.sun.com/xml/ns/j2ee \
         http://java.sun.com/xml/ns/j2ee/web-app_2_4.xsd"> '
    @constant
    def XML_END():
        return '</web-app>'
    @constant
    def SERVLET_XML_START1():
        return ' <servlet> <servlet-name>owasp-webgoat-benchmark '
    @constant
    def SERVLET_XML_START2():
        return '</servlet-name> <servlet-class>org.owasp.webgoat.benchmark.testcode.'
    @constant
    def SERVLET_XML_START3():
        return '</servlet-class> </servlet> <servlet-mapping> \
         <servlet-name>owasp-webgoat-benchmark '
    @constant
    def SERVLET_XML_START4():
        return '</servlet-name><url-pattern>/'
    @constant
    def SERVLET_XML_START5():
        return '</url-pattern></servlet-mapping>'
    
CONST = _Const()

