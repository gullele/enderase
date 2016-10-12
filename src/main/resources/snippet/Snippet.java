package snippet;

public class Snippet {
	<?xml version="1.0" encoding="utf-8"?>
	<!DOCTYPE hibernate-configuration PUBLIC
	"-//Hibernate/Hibernate Configuration DTD 3.0//EN"
	"http://hibernate.sourceforge.net/hibernate-configuration-3.0.dtd">
	<hibernate-configuration>
		 <session-factory>
		  
		    <property name="connection.url">jdbc:mysql://localhost:3306/enderase</property>
		    <property name="connection.username">root</property>
		    <property name="connection.password">123</property>
		    <property name="connection.driver_class">com.mysql.jdbc.Driver</property>
		    <property name="dialect">org.hibernate.dialect.MySQLDialect</property>
		  
		    <property name="show_sql">true</property>
		  
		    <property name="format_sql">true</property>
		    <property name="hbm2ddl.auto">create</property>
		  
		    <!-- JDBC connection pool (use the built-in) -->
		    <property name="connection.pool_size">1</property>
		    <property name="current_session_context_class">thread</property>
			<mapping class="com.enderase.entities.Member"/>	
		</session-factory>
	</hibernate-configuration>
	
}

