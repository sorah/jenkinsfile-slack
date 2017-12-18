def call(String buildStatus) {
  def status = buildStatus ?: 'SUCCESS'
  def color = '#e3e4e6'
  def statusMessage = status

  if (status == 'STARTED') {
    color = '#e3e4e6'
    statusMessage = 'Started'
  }
  if (status == 'SUCCESS') {
    color = 'good'
    statusMessage = 'Success'
  }
  if (status == 'FAILURE') {
    color = 'danger'
    statusMessage = 'FAILURE'
  }
  if (status == 'ABORTED') {
    color = 'warning'
    statusMessage = 'Aborted'
  }
  if (status == 'NOT_BUILT') {
    color = 'warning'
    statusMessage = 'Not built'
  }
  if (status == 'UNSTABLE') {
    color = 'danger'
    statusMessage = 'Unstable'
  }

  def message = "${env.JOB_NAME} <${env.BUILD_URL}|#${env.BUILD_NUMBER}> ${statusMessage}"

  slackSend (color: color, message: message)
}
