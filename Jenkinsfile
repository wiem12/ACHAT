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
              
sh '  mvn sonar:sonar -Dsonar.login=ea6ea839b3be8f9c9bdf47c50348a95df2a48a3e'

            }
        }
stage ('Test Unitaire')
        {
        steps {
        sh 'mvn test -Dtest="tn.esprit.rh.achat.services.StockServiceImplMock.java"' 
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
