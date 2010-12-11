require 'java'
StupidClass = JavaUtilities.create_proxy_class(
  'StupidClass',
  JavaUtilities.get_java_class('net.juckel.osgijrubytest.StupidClass', $foo),
  JavaUtilities.get_proxy_or_package_under_package('net.juckel.osgijrubytest', $foo))
puts "What is StupidClass? #{StupidClass.class}, #{StupidClass}"
c = StupidClass.new
puts "Value #{c.stuff}"

1
