pipeline {
     environment { 

        registry = "hantous/alpine" 

        registryCredential = 'dockerhub_id' 

        dockerImage = '' 

    }
  agent any
  tools {
        // Install the Maven version configured as "M3" and add it to the path.
        maven "M2_HOME"
    }
   
stages {
        stage('GIT') {
          steps {
           git branch: 'jihen',url: 'https://github.com/wiem12/ACHAT.git',
           credentialsId: 'jihen';
        }
      }

stage('CLEANING') {
  steps {
   sh 'mvn clean'
                   }
}

stage('COMPILING') {
             
             
            steps {
echo "compiling"
                sh 'mvn compile'
               
            }
        }
          stage('SONAR') {
             
             
            steps {
              
sh '  mvn sonar:sonar -Dsonar.login=b0c41c5575fa768bbdde9047fd18c14347910e69'

            }
        }
stage ('MOCKITO')
        {
        steps {
        sh 'mvn test -Dtest="tn.esprit.rh.achat.services.StockServiceImplMock.java"' 
        }
        }
        
         stage('BUILD IMAGE') { 

            steps { 

                script { 

                    dockerImage = docker.build registry + ":$BUILD_NUMBER" 

                }

            } 

        }

        stage('DEPLOY IMAGE') { 

            steps { 

                script { 

                    docker.withRegistry( '', registryCredential ) { 

                        dockerImage.push() 

                    }

                } 

            }

        } 

        stage('CLEANING UP') { 

            steps { 

                sh "docker rmi $registry:$BUILD_NUMBER" 

            }

        }
         stage('DOCKER COMPOSE'){
        
        steps {
        
        sh "docker-compose up -d"
        
        }
        
        }
      
 
}
}
