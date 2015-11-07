package models

/**
 * Created by ha on 2/15/14.
 */

trait HasCareer {
  var careers:Map[Career,Double]=Map()

  def addCareer(careers: Map[Career,Double]) {
    this.careers = this.careers ++ careers
  }

  def getCareers(ceiling: Double=1, floor: Double=0):List[(Career, Double)] = {

    val sortedSkills = this.careers.toList sortBy{- _._2}

    sortedSkills.iterator
      .filter(_._2 <= ceiling)
      .filter(_._2 >= floor)
      .toList
  }
}

trait HasCategories {
  var categories:List[Category]=List()

  def addCategories(cat: List[Category]) {
    this.categories = cat
  }
}

trait HasJobs {
  var jobs:Map[Job,Double]=Map()

  def addJobs(jobs: Map[Job,Double]) {
    this.jobs = this.jobs ++ jobs
    /*
    for (job <- jobs) {
      val jobEntity = job._1
      val weight = job._2
      job.addCareers
    }
    */
  }

  def getJobs(ceiling: Double=1, floor: Double=0):List[(Job, Double)] = {

    val sortedSkills = this.jobs.toList sortBy{- _._2}

    sortedSkills.iterator
      .filter(_._2 <= ceiling)
      .filter(_._2 >= floor)
      .toList
  }
}

trait HasSkills {
  var skills:Map[Skill,Double]=Map()

  def addSkills(skills: Map[Skill,Double]) {
    this.skills = this.skills ++ skills
  }

  def getSkills(ceiling: Double=1, floor: Double=0):List[(Skill,Double)] = {

    val sortedSkills = this.skills.toList sortBy{- _._2}

    sortedSkills.iterator
      .filter(_._2 <= ceiling)
      .filter(_._2 >= floor)
      .toList
  }

  def getSkillIds:List[String] = {
    var list: List[String] = List()
    this.skills.toList.foldLeft(list)((r,c) => r :+ c._1.id)
  }
}


