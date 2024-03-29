/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 0.9.4.3</a>, using an XML
 * Schema.
 * $Id: ConfigurationDescriptor.java,v 1.1 2010/06/18 16:43:53 smhuang Exp $
 */

package org.exolab.jms.config;

  //---------------------------------/
 //- Imported classes and packages -/
//---------------------------------/

import org.exolab.castor.mapping.AccessMode;
import org.exolab.castor.xml.TypeValidator;
import org.exolab.castor.xml.XMLFieldDescriptor;
import org.exolab.castor.xml.validators.*;

/**
 * Class ConfigurationDescriptor.
 * 
 * @version $Revision: 1.1 $ $Date: 2010/06/18 16:43:53 $
 */
public class ConfigurationDescriptor extends org.exolab.castor.xml.util.XMLClassDescriptorImpl {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field nsPrefix
     */
    private java.lang.String nsPrefix;

    /**
     * Field nsURI
     */
    private java.lang.String nsURI;

    /**
     * Field xmlName
     */
    private java.lang.String xmlName;

    /**
     * Field identity
     */
    private org.exolab.castor.xml.XMLFieldDescriptor identity;


      //----------------/
     //- Constructors -/
    //----------------/

    public ConfigurationDescriptor() {
        super();
        nsURI = "http://openjms.exolab.org/configuration";
        xmlName = "Configuration";
        
        //-- set grouping compositor
        setCompositorAsSequence();
        org.exolab.castor.xml.util.XMLFieldDescriptorImpl  desc           = null;
        org.exolab.castor.xml.XMLFieldHandler              handler        = null;
        org.exolab.castor.xml.FieldValidator               fieldValidator = null;
        //-- initialize attribute descriptors
        
        //-- initialize element descriptors
        
        //-- _databaseConfiguration
        desc = new org.exolab.castor.xml.util.XMLFieldDescriptorImpl(org.exolab.jms.config.DatabaseConfiguration.class, "_databaseConfiguration", "DatabaseConfiguration", org.exolab.castor.xml.NodeType.Element);
        handler = (new org.exolab.castor.xml.XMLFieldHandler() {
            public java.lang.Object getValue( java.lang.Object object ) 
                throws IllegalStateException
            {
                Configuration target = (Configuration) object;
                return target.getDatabaseConfiguration();
            }
            public void setValue( java.lang.Object object, java.lang.Object value) 
                throws IllegalStateException, IllegalArgumentException
            {
                try {
                    Configuration target = (Configuration) object;
                    target.setDatabaseConfiguration( (org.exolab.jms.config.DatabaseConfiguration) value);
                }
                catch (java.lang.Exception ex) {
                    throw new IllegalStateException(ex.toString());
                }
            }
            public java.lang.Object newInstance( java.lang.Object parent ) {
                return new org.exolab.jms.config.DatabaseConfiguration();
            }
        } );
        desc.setHandler(handler);
        desc.setRequired(true);
        desc.setMultivalued(false);
        addFieldDescriptor(desc);
        
        //-- validation code for: _databaseConfiguration
        fieldValidator = new org.exolab.castor.xml.FieldValidator();
        fieldValidator.setMinOccurs(1);
        { //-- local scope
        }
        desc.setValidator(fieldValidator);
        //-- _adminConfiguration
        desc = new org.exolab.castor.xml.util.XMLFieldDescriptorImpl(org.exolab.jms.config.AdminConfiguration.class, "_adminConfiguration", "AdminConfiguration", org.exolab.castor.xml.NodeType.Element);
        handler = (new org.exolab.castor.xml.XMLFieldHandler() {
            public java.lang.Object getValue( java.lang.Object object ) 
                throws IllegalStateException
            {
                Configuration target = (Configuration) object;
                return target.getAdminConfiguration();
            }
            public void setValue( java.lang.Object object, java.lang.Object value) 
                throws IllegalStateException, IllegalArgumentException
            {
                try {
                    Configuration target = (Configuration) object;
                    target.setAdminConfiguration( (org.exolab.jms.config.AdminConfiguration) value);
                }
                catch (java.lang.Exception ex) {
                    throw new IllegalStateException(ex.toString());
                }
            }
            public java.lang.Object newInstance( java.lang.Object parent ) {
                return new org.exolab.jms.config.AdminConfiguration();
            }
        } );
        desc.setHandler(handler);
        desc.setRequired(true);
        desc.setMultivalued(false);
        addFieldDescriptor(desc);
        
        //-- validation code for: _adminConfiguration
        fieldValidator = new org.exolab.castor.xml.FieldValidator();
        fieldValidator.setMinOccurs(1);
        { //-- local scope
        }
        desc.setValidator(fieldValidator);
        //-- _serverConfiguration
        desc = new org.exolab.castor.xml.util.XMLFieldDescriptorImpl(org.exolab.jms.config.ServerConfiguration.class, "_serverConfiguration", "ServerConfiguration", org.exolab.castor.xml.NodeType.Element);
        handler = (new org.exolab.castor.xml.XMLFieldHandler() {
            public java.lang.Object getValue( java.lang.Object object ) 
                throws IllegalStateException
            {
                Configuration target = (Configuration) object;
                return target.getServerConfiguration();
            }
            public void setValue( java.lang.Object object, java.lang.Object value) 
                throws IllegalStateException, IllegalArgumentException
            {
                try {
                    Configuration target = (Configuration) object;
                    target.setServerConfiguration( (org.exolab.jms.config.ServerConfiguration) value);
                }
                catch (java.lang.Exception ex) {
                    throw new IllegalStateException(ex.toString());
                }
            }
            public java.lang.Object newInstance( java.lang.Object parent ) {
                return new org.exolab.jms.config.ServerConfiguration();
            }
        } );
        desc.setHandler(handler);
        desc.setMultivalued(false);
        addFieldDescriptor(desc);
        
        //-- validation code for: _serverConfiguration
        fieldValidator = new org.exolab.castor.xml.FieldValidator();
        { //-- local scope
        }
        desc.setValidator(fieldValidator);
        //-- _connectors
        desc = new org.exolab.castor.xml.util.XMLFieldDescriptorImpl(org.exolab.jms.config.Connectors.class, "_connectors", "Connectors", org.exolab.castor.xml.NodeType.Element);
        handler = (new org.exolab.castor.xml.XMLFieldHandler() {
            public java.lang.Object getValue( java.lang.Object object ) 
                throws IllegalStateException
            {
                Configuration target = (Configuration) object;
                return target.getConnectors();
            }
            public void setValue( java.lang.Object object, java.lang.Object value) 
                throws IllegalStateException, IllegalArgumentException
            {
                try {
                    Configuration target = (Configuration) object;
                    target.setConnectors( (org.exolab.jms.config.Connectors) value);
                }
                catch (java.lang.Exception ex) {
                    throw new IllegalStateException(ex.toString());
                }
            }
            public java.lang.Object newInstance( java.lang.Object parent ) {
                return new org.exolab.jms.config.Connectors();
            }
        } );
        desc.setHandler(handler);
        desc.setMultivalued(false);
        addFieldDescriptor(desc);
        
        //-- validation code for: _connectors
        fieldValidator = new org.exolab.castor.xml.FieldValidator();
        { //-- local scope
        }
        desc.setValidator(fieldValidator);
        //-- _tcpConfiguration
        desc = new org.exolab.castor.xml.util.XMLFieldDescriptorImpl(org.exolab.jms.config.TcpConfiguration.class, "_tcpConfiguration", "TcpConfiguration", org.exolab.castor.xml.NodeType.Element);
        handler = (new org.exolab.castor.xml.XMLFieldHandler() {
            public java.lang.Object getValue( java.lang.Object object ) 
                throws IllegalStateException
            {
                Configuration target = (Configuration) object;
                return target.getTcpConfiguration();
            }
            public void setValue( java.lang.Object object, java.lang.Object value) 
                throws IllegalStateException, IllegalArgumentException
            {
                try {
                    Configuration target = (Configuration) object;
                    target.setTcpConfiguration( (org.exolab.jms.config.TcpConfiguration) value);
                }
                catch (java.lang.Exception ex) {
                    throw new IllegalStateException(ex.toString());
                }
            }
            public java.lang.Object newInstance( java.lang.Object parent ) {
                return new org.exolab.jms.config.TcpConfiguration();
            }
        } );
        desc.setHandler(handler);
        desc.setMultivalued(false);
        addFieldDescriptor(desc);
        
        //-- validation code for: _tcpConfiguration
        fieldValidator = new org.exolab.castor.xml.FieldValidator();
        { //-- local scope
        }
        desc.setValidator(fieldValidator);
        //-- _tcpsConfiguration
        desc = new org.exolab.castor.xml.util.XMLFieldDescriptorImpl(org.exolab.jms.config.TcpsConfiguration.class, "_tcpsConfiguration", "TcpsConfiguration", org.exolab.castor.xml.NodeType.Element);
        handler = (new org.exolab.castor.xml.XMLFieldHandler() {
            public java.lang.Object getValue( java.lang.Object object ) 
                throws IllegalStateException
            {
                Configuration target = (Configuration) object;
                return target.getTcpsConfiguration();
            }
            public void setValue( java.lang.Object object, java.lang.Object value) 
                throws IllegalStateException, IllegalArgumentException
            {
                try {
                    Configuration target = (Configuration) object;
                    target.setTcpsConfiguration( (org.exolab.jms.config.TcpsConfiguration) value);
                }
                catch (java.lang.Exception ex) {
                    throw new IllegalStateException(ex.toString());
                }
            }
            public java.lang.Object newInstance( java.lang.Object parent ) {
                return new org.exolab.jms.config.TcpsConfiguration();
            }
        } );
        desc.setHandler(handler);
        desc.setMultivalued(false);
        addFieldDescriptor(desc);
        
        //-- validation code for: _tcpsConfiguration
        fieldValidator = new org.exolab.castor.xml.FieldValidator();
        { //-- local scope
        }
        desc.setValidator(fieldValidator);
        //-- _rmiConfiguration
        desc = new org.exolab.castor.xml.util.XMLFieldDescriptorImpl(org.exolab.jms.config.RmiConfiguration.class, "_rmiConfiguration", "RmiConfiguration", org.exolab.castor.xml.NodeType.Element);
        handler = (new org.exolab.castor.xml.XMLFieldHandler() {
            public java.lang.Object getValue( java.lang.Object object ) 
                throws IllegalStateException
            {
                Configuration target = (Configuration) object;
                return target.getRmiConfiguration();
            }
            public void setValue( java.lang.Object object, java.lang.Object value) 
                throws IllegalStateException, IllegalArgumentException
            {
                try {
                    Configuration target = (Configuration) object;
                    target.setRmiConfiguration( (org.exolab.jms.config.RmiConfiguration) value);
                }
                catch (java.lang.Exception ex) {
                    throw new IllegalStateException(ex.toString());
                }
            }
            public java.lang.Object newInstance( java.lang.Object parent ) {
                return new org.exolab.jms.config.RmiConfiguration();
            }
        } );
        desc.setHandler(handler);
        desc.setMultivalued(false);
        addFieldDescriptor(desc);
        
        //-- validation code for: _rmiConfiguration
        fieldValidator = new org.exolab.castor.xml.FieldValidator();
        { //-- local scope
        }
        desc.setValidator(fieldValidator);
        //-- _httpConfiguration
        desc = new org.exolab.castor.xml.util.XMLFieldDescriptorImpl(org.exolab.jms.config.HttpConfiguration.class, "_httpConfiguration", "HttpConfiguration", org.exolab.castor.xml.NodeType.Element);
        handler = (new org.exolab.castor.xml.XMLFieldHandler() {
            public java.lang.Object getValue( java.lang.Object object ) 
                throws IllegalStateException
            {
                Configuration target = (Configuration) object;
                return target.getHttpConfiguration();
            }
            public void setValue( java.lang.Object object, java.lang.Object value) 
                throws IllegalStateException, IllegalArgumentException
            {
                try {
                    Configuration target = (Configuration) object;
                    target.setHttpConfiguration( (org.exolab.jms.config.HttpConfiguration) value);
                }
                catch (java.lang.Exception ex) {
                    throw new IllegalStateException(ex.toString());
                }
            }
            public java.lang.Object newInstance( java.lang.Object parent ) {
                return new org.exolab.jms.config.HttpConfiguration();
            }
        } );
        desc.setHandler(handler);
        desc.setMultivalued(false);
        addFieldDescriptor(desc);
        
        //-- validation code for: _httpConfiguration
        fieldValidator = new org.exolab.castor.xml.FieldValidator();
        { //-- local scope
        }
        desc.setValidator(fieldValidator);
        //-- _httpsConfiguration
        desc = new org.exolab.castor.xml.util.XMLFieldDescriptorImpl(org.exolab.jms.config.HttpsConfiguration.class, "_httpsConfiguration", "HttpsConfiguration", org.exolab.castor.xml.NodeType.Element);
        handler = (new org.exolab.castor.xml.XMLFieldHandler() {
            public java.lang.Object getValue( java.lang.Object object ) 
                throws IllegalStateException
            {
                Configuration target = (Configuration) object;
                return target.getHttpsConfiguration();
            }
            public void setValue( java.lang.Object object, java.lang.Object value) 
                throws IllegalStateException, IllegalArgumentException
            {
                try {
                    Configuration target = (Configuration) object;
                    target.setHttpsConfiguration( (org.exolab.jms.config.HttpsConfiguration) value);
                }
                catch (java.lang.Exception ex) {
                    throw new IllegalStateException(ex.toString());
                }
            }
            public java.lang.Object newInstance( java.lang.Object parent ) {
                return new org.exolab.jms.config.HttpsConfiguration();
            }
        } );
        desc.setHandler(handler);
        desc.setMultivalued(false);
        addFieldDescriptor(desc);
        
        //-- validation code for: _httpsConfiguration
        fieldValidator = new org.exolab.castor.xml.FieldValidator();
        { //-- local scope
        }
        desc.setValidator(fieldValidator);
        //-- _jndiConfiguration
        desc = new org.exolab.castor.xml.util.XMLFieldDescriptorImpl(org.exolab.jms.config.JndiConfiguration.class, "_jndiConfiguration", "JndiConfiguration", org.exolab.castor.xml.NodeType.Element);
        handler = (new org.exolab.castor.xml.XMLFieldHandler() {
            public java.lang.Object getValue( java.lang.Object object ) 
                throws IllegalStateException
            {
                Configuration target = (Configuration) object;
                return target.getJndiConfiguration();
            }
            public void setValue( java.lang.Object object, java.lang.Object value) 
                throws IllegalStateException, IllegalArgumentException
            {
                try {
                    Configuration target = (Configuration) object;
                    target.setJndiConfiguration( (org.exolab.jms.config.JndiConfiguration) value);
                }
                catch (java.lang.Exception ex) {
                    throw new IllegalStateException(ex.toString());
                }
            }
            public java.lang.Object newInstance( java.lang.Object parent ) {
                return new org.exolab.jms.config.JndiConfiguration();
            }
        } );
        desc.setHandler(handler);
        desc.setMultivalued(false);
        addFieldDescriptor(desc);
        
        //-- validation code for: _jndiConfiguration
        fieldValidator = new org.exolab.castor.xml.FieldValidator();
        { //-- local scope
        }
        desc.setValidator(fieldValidator);
        //-- _messageManagerConfiguration
        desc = new org.exolab.castor.xml.util.XMLFieldDescriptorImpl(org.exolab.jms.config.MessageManagerConfiguration.class, "_messageManagerConfiguration", "MessageManagerConfiguration", org.exolab.castor.xml.NodeType.Element);
        handler = (new org.exolab.castor.xml.XMLFieldHandler() {
            public java.lang.Object getValue( java.lang.Object object ) 
                throws IllegalStateException
            {
                Configuration target = (Configuration) object;
                return target.getMessageManagerConfiguration();
            }
            public void setValue( java.lang.Object object, java.lang.Object value) 
                throws IllegalStateException, IllegalArgumentException
            {
                try {
                    Configuration target = (Configuration) object;
                    target.setMessageManagerConfiguration( (org.exolab.jms.config.MessageManagerConfiguration) value);
                }
                catch (java.lang.Exception ex) {
                    throw new IllegalStateException(ex.toString());
                }
            }
            public java.lang.Object newInstance( java.lang.Object parent ) {
                return new org.exolab.jms.config.MessageManagerConfiguration();
            }
        } );
        desc.setHandler(handler);
        desc.setMultivalued(false);
        addFieldDescriptor(desc);
        
        //-- validation code for: _messageManagerConfiguration
        fieldValidator = new org.exolab.castor.xml.FieldValidator();
        { //-- local scope
        }
        desc.setValidator(fieldValidator);
        //-- _schedulerConfiguration
        desc = new org.exolab.castor.xml.util.XMLFieldDescriptorImpl(org.exolab.jms.config.SchedulerConfiguration.class, "_schedulerConfiguration", "SchedulerConfiguration", org.exolab.castor.xml.NodeType.Element);
        handler = (new org.exolab.castor.xml.XMLFieldHandler() {
            public java.lang.Object getValue( java.lang.Object object ) 
                throws IllegalStateException
            {
                Configuration target = (Configuration) object;
                return target.getSchedulerConfiguration();
            }
            public void setValue( java.lang.Object object, java.lang.Object value) 
                throws IllegalStateException, IllegalArgumentException
            {
                try {
                    Configuration target = (Configuration) object;
                    target.setSchedulerConfiguration( (org.exolab.jms.config.SchedulerConfiguration) value);
                }
                catch (java.lang.Exception ex) {
                    throw new IllegalStateException(ex.toString());
                }
            }
            public java.lang.Object newInstance( java.lang.Object parent ) {
                return new org.exolab.jms.config.SchedulerConfiguration();
            }
        } );
        desc.setHandler(handler);
        desc.setMultivalued(false);
        addFieldDescriptor(desc);
        
        //-- validation code for: _schedulerConfiguration
        fieldValidator = new org.exolab.castor.xml.FieldValidator();
        { //-- local scope
        }
        desc.setValidator(fieldValidator);
        //-- _garbageCollectionConfiguration
        desc = new org.exolab.castor.xml.util.XMLFieldDescriptorImpl(org.exolab.jms.config.GarbageCollectionConfiguration.class, "_garbageCollectionConfiguration", "GarbageCollectionConfiguration", org.exolab.castor.xml.NodeType.Element);
        handler = (new org.exolab.castor.xml.XMLFieldHandler() {
            public java.lang.Object getValue( java.lang.Object object ) 
                throws IllegalStateException
            {
                Configuration target = (Configuration) object;
                return target.getGarbageCollectionConfiguration();
            }
            public void setValue( java.lang.Object object, java.lang.Object value) 
                throws IllegalStateException, IllegalArgumentException
            {
                try {
                    Configuration target = (Configuration) object;
                    target.setGarbageCollectionConfiguration( (org.exolab.jms.config.GarbageCollectionConfiguration) value);
                }
                catch (java.lang.Exception ex) {
                    throw new IllegalStateException(ex.toString());
                }
            }
            public java.lang.Object newInstance( java.lang.Object parent ) {
                return new org.exolab.jms.config.GarbageCollectionConfiguration();
            }
        } );
        desc.setHandler(handler);
        desc.setMultivalued(false);
        addFieldDescriptor(desc);
        
        //-- validation code for: _garbageCollectionConfiguration
        fieldValidator = new org.exolab.castor.xml.FieldValidator();
        { //-- local scope
        }
        desc.setValidator(fieldValidator);
        //-- _loggerConfiguration
        desc = new org.exolab.castor.xml.util.XMLFieldDescriptorImpl(org.exolab.jms.config.LoggerConfiguration.class, "_loggerConfiguration", "LoggerConfiguration", org.exolab.castor.xml.NodeType.Element);
        handler = (new org.exolab.castor.xml.XMLFieldHandler() {
            public java.lang.Object getValue( java.lang.Object object ) 
                throws IllegalStateException
            {
                Configuration target = (Configuration) object;
                return target.getLoggerConfiguration();
            }
            public void setValue( java.lang.Object object, java.lang.Object value) 
                throws IllegalStateException, IllegalArgumentException
            {
                try {
                    Configuration target = (Configuration) object;
                    target.setLoggerConfiguration( (org.exolab.jms.config.LoggerConfiguration) value);
                }
                catch (java.lang.Exception ex) {
                    throw new IllegalStateException(ex.toString());
                }
            }
            public java.lang.Object newInstance( java.lang.Object parent ) {
                return new org.exolab.jms.config.LoggerConfiguration();
            }
        } );
        desc.setHandler(handler);
        desc.setMultivalued(false);
        addFieldDescriptor(desc);
        
        //-- validation code for: _loggerConfiguration
        fieldValidator = new org.exolab.castor.xml.FieldValidator();
        { //-- local scope
        }
        desc.setValidator(fieldValidator);
        //-- _securityConfiguration
        desc = new org.exolab.castor.xml.util.XMLFieldDescriptorImpl(org.exolab.jms.config.SecurityConfiguration.class, "_securityConfiguration", "SecurityConfiguration", org.exolab.castor.xml.NodeType.Element);
        handler = (new org.exolab.castor.xml.XMLFieldHandler() {
            public java.lang.Object getValue( java.lang.Object object ) 
                throws IllegalStateException
            {
                Configuration target = (Configuration) object;
                return target.getSecurityConfiguration();
            }
            public void setValue( java.lang.Object object, java.lang.Object value) 
                throws IllegalStateException, IllegalArgumentException
            {
                try {
                    Configuration target = (Configuration) object;
                    target.setSecurityConfiguration( (org.exolab.jms.config.SecurityConfiguration) value);
                }
                catch (java.lang.Exception ex) {
                    throw new IllegalStateException(ex.toString());
                }
            }
            public java.lang.Object newInstance( java.lang.Object parent ) {
                return new org.exolab.jms.config.SecurityConfiguration();
            }
        } );
        desc.setHandler(handler);
        desc.setMultivalued(false);
        addFieldDescriptor(desc);
        
        //-- validation code for: _securityConfiguration
        fieldValidator = new org.exolab.castor.xml.FieldValidator();
        { //-- local scope
        }
        desc.setValidator(fieldValidator);
        //-- _users
        desc = new org.exolab.castor.xml.util.XMLFieldDescriptorImpl(org.exolab.jms.config.Users.class, "_users", "Users", org.exolab.castor.xml.NodeType.Element);
        handler = (new org.exolab.castor.xml.XMLFieldHandler() {
            public java.lang.Object getValue( java.lang.Object object ) 
                throws IllegalStateException
            {
                Configuration target = (Configuration) object;
                return target.getUsers();
            }
            public void setValue( java.lang.Object object, java.lang.Object value) 
                throws IllegalStateException, IllegalArgumentException
            {
                try {
                    Configuration target = (Configuration) object;
                    target.setUsers( (org.exolab.jms.config.Users) value);
                }
                catch (java.lang.Exception ex) {
                    throw new IllegalStateException(ex.toString());
                }
            }
            public java.lang.Object newInstance( java.lang.Object parent ) {
                return new org.exolab.jms.config.Users();
            }
        } );
        desc.setHandler(handler);
        desc.setMultivalued(false);
        addFieldDescriptor(desc);
        
        //-- validation code for: _users
        fieldValidator = new org.exolab.castor.xml.FieldValidator();
        { //-- local scope
        }
        desc.setValidator(fieldValidator);
        //-- _administeredDestinations
        desc = new org.exolab.castor.xml.util.XMLFieldDescriptorImpl(org.exolab.jms.config.AdministeredDestinations.class, "_administeredDestinations", "AdministeredDestinations", org.exolab.castor.xml.NodeType.Element);
        handler = (new org.exolab.castor.xml.XMLFieldHandler() {
            public java.lang.Object getValue( java.lang.Object object ) 
                throws IllegalStateException
            {
                Configuration target = (Configuration) object;
                return target.getAdministeredDestinations();
            }
            public void setValue( java.lang.Object object, java.lang.Object value) 
                throws IllegalStateException, IllegalArgumentException
            {
                try {
                    Configuration target = (Configuration) object;
                    target.setAdministeredDestinations( (org.exolab.jms.config.AdministeredDestinations) value);
                }
                catch (java.lang.Exception ex) {
                    throw new IllegalStateException(ex.toString());
                }
            }
            public java.lang.Object newInstance( java.lang.Object parent ) {
                return new org.exolab.jms.config.AdministeredDestinations();
            }
        } );
        desc.setHandler(handler);
        desc.setMultivalued(false);
        addFieldDescriptor(desc);
        
        //-- validation code for: _administeredDestinations
        fieldValidator = new org.exolab.castor.xml.FieldValidator();
        { //-- local scope
        }
        desc.setValidator(fieldValidator);
        //-- _connectorResources
        desc = new org.exolab.castor.xml.util.XMLFieldDescriptorImpl(org.exolab.jms.config.ConnectorResources.class, "_connectorResources", "connectorResources", org.exolab.castor.xml.NodeType.Element);
        handler = (new org.exolab.castor.xml.XMLFieldHandler() {
            public java.lang.Object getValue( java.lang.Object object ) 
                throws IllegalStateException
            {
                Configuration target = (Configuration) object;
                return target.getConnectorResources();
            }
            public void setValue( java.lang.Object object, java.lang.Object value) 
                throws IllegalStateException, IllegalArgumentException
            {
                try {
                    Configuration target = (Configuration) object;
                    target.setConnectorResources( (org.exolab.jms.config.ConnectorResources) value);
                }
                catch (java.lang.Exception ex) {
                    throw new IllegalStateException(ex.toString());
                }
            }
            public java.lang.Object newInstance( java.lang.Object parent ) {
                return new org.exolab.jms.config.ConnectorResources();
            }
        } );
        desc.setHandler(handler);
        desc.setMultivalued(false);
        addFieldDescriptor(desc);
        
        //-- validation code for: _connectorResources
        fieldValidator = new org.exolab.castor.xml.FieldValidator();
        { //-- local scope
        }
        desc.setValidator(fieldValidator);
    } //-- org.exolab.jms.config.ConfigurationDescriptor()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Method getAccessMode
     */
    public org.exolab.castor.mapping.AccessMode getAccessMode()
    {
        return null;
    } //-- org.exolab.castor.mapping.AccessMode getAccessMode() 

    /**
     * Method getExtends
     */
    public org.exolab.castor.mapping.ClassDescriptor getExtends()
    {
        return null;
    } //-- org.exolab.castor.mapping.ClassDescriptor getExtends() 

    /**
     * Method getIdentity
     */
    public org.exolab.castor.mapping.FieldDescriptor getIdentity()
    {
        return identity;
    } //-- org.exolab.castor.mapping.FieldDescriptor getIdentity() 

    /**
     * Method getJavaClass
     */
    public java.lang.Class getJavaClass()
    {
        return org.exolab.jms.config.Configuration.class;
    } //-- java.lang.Class getJavaClass() 

    /**
     * Method getNameSpacePrefix
     */
    public java.lang.String getNameSpacePrefix()
    {
        return nsPrefix;
    } //-- java.lang.String getNameSpacePrefix() 

    /**
     * Method getNameSpaceURI
     */
    public java.lang.String getNameSpaceURI()
    {
        return nsURI;
    } //-- java.lang.String getNameSpaceURI() 

    /**
     * Method getValidator
     */
    public org.exolab.castor.xml.TypeValidator getValidator()
    {
        return this;
    } //-- org.exolab.castor.xml.TypeValidator getValidator() 

    /**
     * Method getXMLName
     */
    public java.lang.String getXMLName()
    {
        return xmlName;
    } //-- java.lang.String getXMLName() 

}
