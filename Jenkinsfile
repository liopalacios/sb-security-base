pipeline{
    agent any
    tools {
        maven 'M3'   // usa el Maven que configuraste en Global Tools
    }
    environment {
        SONARQUBE_ENV = 'Sonarqube'   // Debe coincidir con el nombre configurado en Jenkins
        DOCKER_IMAGE = "sb-security-base"   // nombre de tu app/imagen
        DOCKER_TAG   = "latest"             // etiqueta (puede ser latest, 1.0.0, etc.)
    }
    stages{
        stage('Init') {
            steps {
                echo '✅ Inicio de pipeline'
            }
        }
        stage('Checkout'){
            steps{
                // Clona el repositorio y la rama que seleccionaste en el job
                checkout scm
            }
        }

        stage('Build'){
            steps{
                echo "🚀 Sí está ejecutando este Jenkinsfile"
                // Compila y genera el JAR
                dir('digital') {
                    sh './gradlew clean build'
                }
            }
        }
        stage('Check Plugin') {
          steps {
            withSonarQubeEnv('Sonarqube') {
              sh 'echo "SonarQube env loaded!"'
            }
          }
        }
        stage('SonarQube analysis') {
            steps {
                dir('digital') {
                    withSonarQubeEnv("${SONARQUBE_ENV}") {
                        sh './gradlew test jacocoTestReport sonar -Dsonar.projectKey=sb-security-base -Dsonar.host.url=http://sonarqube:9000 -Dsonar.token=sqa_7f1a122fb5c42f762ca8d484bfd6c7bd185b99bf'
                    }
                }
            }
        }
        stage('Quality Gate') {
            steps {
                dir('digital') {
                    timeout(time: 3, unit: 'MINUTES') {
                        waitForQualityGate abortPipeline: true
                    }
                }
            }
        }
        stage('Build Docker Image') {
             steps {
                 dir('digital') {
                     sh "docker build -t ${DOCKER_IMAGE}:${DOCKER_TAG} -f Dockerfile ."
                 }
             }
         }

        stage('Run Docker Container') {
             steps {
                 sh """
                     docker rm -f ${DOCKER_IMAGE} || true
                     docker run -d --name ${DOCKER_IMAGE} -p 8201:8201 ${DOCKER_IMAGE}:${DOCKER_TAG}
                 """
             }
         }
    }
    post{
        success{
            echo "✅ Build exitoso. JAR generado en target/"
        }
        failure{
            echo "❌ Error en el build."
        }
    }
}
