#Setup Development Environment

# MySQL #
Install MySQL 5.x

Install MySQL workbench 5.2

Create user vipro with password="password".

Create Schema vipro.

Grant DBA and all permissions to user vipro.

Run vipro.sql to create all tables.

Run dml.sql to populate data.

# Install Tomcat 6.0.x #

# Setup eclipse #
Install svn plugin if you don't have it.

Checkout source from https://virtuallage.googlecode.com/svn/trunk/vipro

Create tomcat server in eclipse.

Add project to tomcat server.

Start Server.

Visit http://localhost:8080/vipro/

login "root", password is "password"