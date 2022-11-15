pipeline {
  agent any
  	
  tools {
        // Install the Maven version configured as "M3" and add it to the path.
        maven "M2_HOME"
    }
stages {
        stage('Git') {
          steps {
           git branch: 'Rima',url: 'https://github.com/wiem12/ACHAT.git';
            credentialsId: 'Rima';
        }
      }

stage('Clean') {
  steps {
   sh 'mvn clean'
                   }
}
stage('Artifact Construction') {
             
             
            steps {
                sh 'mvn package'
            }
        }

stage('Compiling the artifact') {
             
             
            steps {
echo "compiling"
                sh 'mvn compile'
               
            }
        }
          
stage('JUNIT / MOCKITO'){
            steps{
                sh 'mvn test'
            }
            
        }
        stage('SonarQube') {
             
             
            steps {
              
sh '  mvn sonar:sonar -Dsonar.sources=src/main/java -Dsonar.css.node=. -Dsonar.java.binaries=. -Dsonar.host.url=http://192.168.33.10:9000/ -Dsonar.login=admin   -Dsonar.password=sonar'

            }
        }
        
 stage('Building our image') {
  steps {
               
sh 'docker build -t rimayari/achat:1.0.0 .'
               
            }
        }
       
               
            
        
        stage('Building image docker-compose') {
          steps {
              sh "docker-compose up -d"
              sh "docker-compose stop"
          }
      }
      
        stage('Nexus') {
            steps {
sh 'mvn deploy:deploy-file -DgroupId=tn.esprit.rh -DartifactId=achat -Dversion=1.0 -DgeneratePom=true -Dpackaging=jar -DrepositoryId=deploymentRepo -Durl=http://192.168.33.10:8081/repository/maven-releases/ -Dfile=target/achat-1.0.jar'
            }
        }
        
        
        }	
       


       


           
        }
