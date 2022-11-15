pipeline {
    agent any
tools {
        // Install the Maven version configured as "M3" and add it to the path.
        maven "M2_HOME"
        
}
	  environment { 
        registry = "wiembargaoui/alpine" 
        registryCredential = 'dockerHub' 
	dockerImage = '' 

    }		
	


    stages {
        stage('Git') {
            steps {
               
                git branch: 'master',
                url: 'https://github.com/wiem12/ACHAT.git',
		    credentialsId: 'wiem12';

            }
        }
       
       


       

stage('Build Project'){
            steps{
                sh 'mvn clean package '
            }
         }
         
           stage('Maven COMPILE') {
             
             
            steps {
echo "compiling"
                sh 'mvn compile'
               
            }
        }
        stage('Mockito Test'){
            steps{
                sh 'mvn test '
            }
         }
         
       




  stage('SonarQube') {
             
             
            steps {
               
script {

sh '  mvn sonar:sonar -Dsonar.sources=src/main/java -Dsonar.css.node=. -Dsonar.java.binaries=. -Dsonar.host.url=http://192.168.33.10:9000/ -Dsonar.login=admin   -Dsonar.password=admina'


 
}
            }      
            }
            
            stage('Building our image') {
  steps {
               
sh 'docker build -t wiembargaoui/achat:1.0.0 .'
               
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
            stage('docker-compose') {
          steps {
              sh "docker-compose up -d"
              sh "docker-compose stop"
          }
      }
            
         
       
            
 }
}
