package cs2.game

import scalafx.scene.canvas.GraphicsContext
import cs2.util.Vec2
import scala.util.Random

/** contains the control and logic to present a coordinated set of Enemy objects.
 *  For now, this class generates a "grid" of enemy objects centered near the
 *  top of the screen.
 *
 *  @param nRows - number of rows of enemy objects
 *  @param nCols - number of columns of enemy objects
 */
class EnemySwarm(private val nRows:Int, private val nCols:Int) {
  /** method to display all Enemy objects contained within this EnemySwarm
   *
   *  @param g - the GraphicsContext to draw into
   *  @return none/Unit
   */
  var swarm = collection.mutable.ListBuffer.empty[Enemy]
  
  for(r <- 1 to nRows){
    for(c <- 1 to nCols){
      swarm += new Enemy(Images.Shinobi,Vec2(200*c+(r-1)*50,100*r),Images.Shuriken)      
    }
  }


  def display(g:GraphicsContext):Unit = {
    for (p <- swarm){
      p.display(g,40,40)
    }
  }
  
  var direction:Vec2 = new Vec2(0,0)
  def beStatic():Unit = {
    for(e <- swarm){
    e.beStatic()
    }
  }

  /** overridden method of ShootsBullets. Creates a single, new bullet instance
   *  originating from a random enemy in the swarm. (Not a bullet from every
   *  object, just a single from a random enemy)
   *
   *  @return Bullet - the newly created Bullet object fired from the swarm
   */
  var arr = Array.range(0,swarm.length)
  def shoot():Bullet = {
    swarm(arr(Random.nextInt(arr.size))).shoot()
  }
  
  

}
