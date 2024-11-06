::/*#! 2> /dev/null                                   #
@ 2>/dev/null # 2>nul & echo off & goto BOF           #
if [ -z "${SIREUM_HOME}" ]; then                      #
  echo "Please set SIREUM_HOME env var"               #
  exit -1                                             #
fi                                                    #
exec "${SIREUM_HOME}/bin/sireum" slang run "$0" "$@"  #
:BOF
setlocal
if not defined SIREUM_HOME (
  echo Please set SIREUM_HOME env var
  exit /B -1
)
"%SIREUM_HOME%\bin\sireum.bat" slang run %0 %*
exit /B %errorlevel%
::!#*/
// #Sireum

import org.sireum._

val content: ST = 
  st"""FROM trustworthysystems/camkes
      |
      |WORKDIR /root
      |
      |ENV SIREUM_HOME=/root/Sireum
      |ENV PATH="$$SIREUM_HOME/bin:$$PATH"
      |
      |RUN git config --global user.email "" &&\
      |    git config --global user.name "" &&\
      |    git config --global color.ui false &&\
      |    mkdir camkes && cd camkes &&\
      |    repo init -u https://github.com/seL4/camkes-manifest.git &&\
      |    repo sync &&\
      |    cd &&\
      |    (export SIREUM_NO_SETUP=true && DIR=Sireum && export SIREUM_V=master && rm -fR $$DIR && mkdir -p $$DIR/bin && cd $$DIR/bin && curl -JLso init.sh https://raw.githubusercontent.com/sireum/kekinian/$$SIREUM_V/bin/init.sh && bash init.sh)
      |"""


val dockerDir = Os.tempDir()
val dockerFile = dockerDir / "Dockerfile"
dockerFile.write(content.render)

proc"docker build -t camkes.sireum .".at(dockerDir).console.runCheck()
