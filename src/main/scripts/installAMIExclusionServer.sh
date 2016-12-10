#!/bin/bash

#############################################################################

THIS_SCRIPT=${BASH_SOURCE[0]:-$0}

while [[ -n $(readlink $THIS_SCRIPT) ]]
do
  THIS_SCRIPT=$(readlink $THIS_SCRIPT)
done

AMI_HOME=$(cd $(dirname $THIS_SCRIPT) && pwd)

#############################################################################

if [[ $(uname -s) == 'Linux' ]]
then
  ###########################################################################

  rm -f /etc/init.d/AMIExclusionServer

  ln -s $AMI_HOME/AMIExclusionServer /etc/init.d/AMIExclusionServer

  ###########################################################################

  chkconfig --add AMIExclusionServer
  chkconfig AMIExclusionServer on

  ###########################################################################
else
  echo 'For Linux only'
fi

#############################################################################
