pipeline{
    agent any
    tools {
        maven 'M3'   // usa el Maven que configuraste en Global Tools
    }
    stages{
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
                    sh 'mvn clean install'  // usando wrapper
                }
            }
        }

        stage('SonarQube analysis') {
            steps {
                withSonarQubeEnv('SonarLocal') {
                    sh 'mvn sonar:sonar -Dsonar.projectKey=mi-proyecto'
                }
            }
        }
        stage('Quality Gate') {
            steps {
                timeout(time: 5, unit: 'MINUTES') {
                    waitForQualityGate abortPipeline: true
                }
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
