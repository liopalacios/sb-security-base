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
                    sh './gradlew build'  // usando wrapper
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
