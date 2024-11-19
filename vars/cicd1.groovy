def download(repo)
{
  git "https://github.com/IntelliqDevops/${repo}.git"
}
def build()
{
  sh 'mvn package'
}
def deploy(jobname,ip,context)
{
  sh 'scp /home/ubuntu/.jenkins/workspace/${jobname}/webapp/target/webapp.war ubuntu@${ip}:/var/lib/tomcat10/webapps/${context}.war'
}
def test(jobname)
{
  sh "java -jar /var/lib/jenkins/workspace/${jobname}/testing.jar"
}
