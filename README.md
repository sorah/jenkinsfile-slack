Jenkins Slack plugin becomes totally useless when using on declarative pipeline.
We have to build a message for every scenario that how build went.

This shared library provides `vars/notifySlack.groovy` to send post-build message to slack.

``` groovy
@Library('github.com/sorah/jenkinsfile-slack@master') _
pipeline {
  post {
    always {
      postNotifySlack currentBuild
    }
  }
}
```

It's totally ugly that this method is explained in the official blog. Jenkinsfile experience is going worse by lack of notification support.
https://jenkins.io/blog/2017/02/15/declarative-notifications/

License: MIT
