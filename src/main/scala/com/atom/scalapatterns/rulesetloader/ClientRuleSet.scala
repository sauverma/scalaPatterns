package com.atom.scalapatterns.rulesetloader

import java.util.{List, Map}

/**
  * Created by sauverma on 24/03/17.
  */

class ClientRuleSet(val clientIds: Array[Integer], val clientRules: Map[Integer, List[Rule]])

object ClientRuleSet {
  @volatile private var _instance: ClientRuleSet = _

  private def initialize(clientIds: Array[Integer], clientRules: Map[Integer, List[Rule]]) = { // singleton
    if (_instance == null) {
      ClientRuleSet.getClass.synchronized {
        if (_instance == null) {
          _instance = new ClientRuleSet(clientIds, clientRules)
        }
      }
    }

    _instance
  }

  def parse(ruleFileLocalPath: String): ClientRuleSet = {
    if (ruleFileLocalPath == null || ruleFileLocalPath.trim.length == 0)
      throw new Exception(s"$ruleFileLocalPath must be a valid file path")

    val lines = scala.io.Source.fromFile(ruleFileLocalPath).mkString

  }
}
