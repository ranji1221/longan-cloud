package org.ranji.lemon.game;

import com.jme3.app.SimpleApplication;
import com.jme3.light.DirectionalLight;
import com.jme3.material.Material;
import com.jme3.math.FastMath;
import com.jme3.math.Vector3f;
import com.jme3.scene.Geometry;
import com.jme3.scene.Mesh;
import com.jme3.scene.shape.Box;
import com.jme3.system.AppSettings;

/**
 * 第一个Java 3D游戏
 * @author RanJi
 * 
 */
public class HelloJME3 extends SimpleApplication{
	
	private Geometry geom;
	
	public static void main(String[] args) {
		//-- 配置参数
		AppSettings settings = new AppSettings(true);
		settings.setTitle("一个方块");	//-- 标题
		settings.setResolution(1366, 768);	//-- 分辨率
		
		//-- 启动JME3程序
		HelloJME3 app = new HelloJME3();
		app.setSettings(settings);	//-- 应用参数
		app.setShowSettings(false);		//-- 阻止配置参数的窗口出现
		app.start();
	}
	/**
	 * 初始化3D场景，显示一个方块。
	 */
	@Override
	public void simpleInitApp() {
		/**
		 * #1 床架一个方块形状的网格
		 */
		Mesh box = new Box(1,1,1);
		
		/**
		 * #2 加载一个感光材质
		 */
		Material mat = new Material(assetManager,"Common/MatDefs/Misc/Unshaded.j3md");
		
		/**
		 * #3 创建一个几何体，应用刚才的网格和材质
		 */
		geom = new Geometry("Box");
		geom.setMesh(box);
		geom.setMaterial(mat);
		
		/**
		 * #4 创建一束定向光，并让它向下照射，好使我们能够看清那个方块
		 */
		DirectionalLight sun = new DirectionalLight();
		sun.setDirection(new Vector3f(-1,-2,-3));
		
		/**
		 * #5 将方块和光源都添加到场景图中
		 */
		rootNode.attachChild(geom);
		rootNode.addLight(sun);
	}
	
	@Override
	public void simpleUpdate(float deltaTime) {
		float speed = FastMath.TWO_PI;
		geom.rotate(0,deltaTime * speed,0);
	}
	
}
