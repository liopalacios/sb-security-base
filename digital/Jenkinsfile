pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                // Clona el repositorio y la rama que seleccionaste en el job
                checkout scm
            }
        }

        stage('Build') {
            steps {
                // Compila y genera el JAR
                sh 'mvn clean package -DskipTests'
            }
        }
    }
    post {
        success {
            echo "✅ Build exitoso. JAR generado en target/"
        }
        failure {
            echo "❌ Error en el build."
        }
    }
}