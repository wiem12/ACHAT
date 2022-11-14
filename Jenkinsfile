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
        stage('Git') {
          steps {
           git branch: 'jihen',url: 'https://github.com/wiem12/ACHAT.git',
           credentialsId: 'jihen';
        }
      }

stage('Clean') {
  steps {
   sh 'mvn clean'
                   }
}

stage('Compiling') {
             
             
            steps {
echo "compiling"
                sh 'mvn compile'
               
            }
        }
          stage('SonarQube') {
             
             
            steps {
              
sh '  mvn sonar:sonar -Dsonar.login=c3e1a771021b9608d72f2cac9150650c3ff6839d'

            }
        }
stage('JUNIT / MOCKITO'){
            steps{
                sh 'mvn test'
            }
        }
        
         stage('Building our image') { 

            steps { 

                script { 

                    dockerImage = docker.build registry + ":$BUILD_NUMBER" 

                }

            } 

        }

        stage('Deploy our image') { 

            steps { 

                script { 

                    docker.withRegistry( '', registryCredential ) { 

                        dockerImage.push() 

                    }

                } 

            }

        } 

        stage('Cleaning up') { 

            steps { 

                sh "docker rmi $registry:$BUILD_NUMBER" 

            }

        }
         stage('Docker Compose'){
        
        steps {
        
        sh "docker-compose up -d"
        
        }
        
        }
      
 
}
}