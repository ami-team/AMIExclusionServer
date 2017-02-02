#!/bin/bash

PORT=1358
JAVA_HOME=/opt/java/latest

#############################################################################

THIS_SCRIPT=${BASH_SOURCE[0]:-$0}

while [[ -n $(readlink $THIS_SCRIPT) ]]
do
  THIS_SCRIPT=$(readlink $THIS_SCRIPT)
done

AMI_HOME=$(cd $(dirname $THIS_SCRIPT) && pwd)

#############################################################################

if [[ -z $(ps -ef | grep "net\.hep\.ami\.exclusion\.Main") ]]
then
  ###########################################################################

  AMICLASSPATH=$AMI_HOME/classes

  for jar in $AMI_HOME/lib/*.jar
  do
    AMICLASSPATH=$AMICLASSPATH:$jar
  done

  ###########################################################################

  if [[ -f $AMI_HOME/log/AMIExclusionServer.out ]]
  then
    mv $AMI_HOME/log/AMIExclusionServer.out $AMI_HOME/log/AMIExclusionServer.$(date +%Y-%m-%d_%Hh%Mm%Ss).out
  fi

  ###########################################################################
  (

    cd $AMI_HOME

    $JAVA_HOME/bin/java -Dfile.encoding=UTF-8 -Djava.awt.headless=true -Djava.security.egd=file:/dev/./urandom -classpath $AMICLASSPATH net.hep.ami.exclusion.Main $PORT &> $AMI_HOME/log/AMIExclusionServer.out &

  )
  ###########################################################################
fi

#############################################################################
