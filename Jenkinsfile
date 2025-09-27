pipeline{
    agent any
    tools {
        maven 'M3'   // usa el Maven que configuraste en Global Tools
    }
    environment {
        SONARQUBE_ENV = 'sonarqube'   // Debe coincidir con el nombre configurado en Jenkins
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
                withSonarQubeEnv("${SONARQUBE_ENV}") {
                    sh 'mvn sonar:sonar -Dsonar.projectKey=sb-security-base'
                }
            }
        }
        stage('Quality Gate') {
            steps {
                timeout(time: 3, unit: 'MINUTES') {
                    waitForQualityGate abortPipeline: true
                }
            }
        }
         stage('Deploy') {
            steps {
                echo '🚀 Desplegando aplicación (solo se ejecuta si el Quality Gate fue OK)'
                // Aquí irían tus pasos reales de despliegue: docker build/push, kubectl, etc.
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
