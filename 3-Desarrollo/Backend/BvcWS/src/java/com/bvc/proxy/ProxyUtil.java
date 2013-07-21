/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bvc.proxy;

import java.util.Properties;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author HansO
 */
public class ProxyUtil {

    public static InitialContext CTX;
    private static ProxyUtil proxyUtil;

    private ProxyUtil() throws NamingException {
        Properties props = new Properties();
        props.setProperty("java.naming.factory.initial", "com.sun.enterprise.naming.SerialInitContextFactory");
        props.setProperty("java.naming.factory.url.pkgs", "com.sun.enterprise.naming");
        props.setProperty("java.naming.factory.state", "com.sun.corba.ee.impl.presentation.rmi.JNDIStateFactoryImpl");
        CTX = new InitialContext(props);
    }

    public static ProxyUtil getInstancia() throws Exception {
        if (proxyUtil == null) {
            try {
                proxyUtil = new ProxyUtil();
            } catch (Exception e) {
                throw new Exception();
            }
        }
        return proxyUtil;
    }
}
