package springbook.learningtest.junit;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.junit.matchers.JUnitMatchers.either;
import static org.junit.matchers.JUnitMatchers.hasItem;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class) //테스트 중 함께 수행할 class 파일이다.
@ContextConfiguration("junit.xml") //ApplicationContext를 지정해 줄 수 있다.
public class JUnitTest {
	@Autowired
	ApplicationContext context; //Autowired 명령을 통해 자동으로 할당한다.

	static Set<JUnitTest> testObjects = new HashSet<JUnitTest>();
	static ApplicationContext contextObject = null; //위에서 Autowired 된 context 와 비교를 위한 임시 변수

	// @Test Annotation을 삽입하면 JUnit에서 해당 메소드를 테스트 단위로 인식한다.
	@Test
	public void test1() {
		assertThat(testObjects, not(hasItem(this)));  //assertThat()의 두 인수가 서로 같지 않으면 false를 반환한다.
		testObjects.add(this);

		assertThat(contextObject == null || contextObject == this.context, is(true)); //둘 중 어떤 것이라도 성립하면 true
		contextObject = this.context;
	}

	@Test
	public void test2() {
		assertThat(testObjects, not(hasItem(this)));
		testObjects.add(this);

		assertTrue(contextObject == null || contextObject == this.context); //해당 조건이 맞으면 true, 아니면 fasle
		contextObject = this.context;
	}

	@Test
	public void test3() {
		assertThat(testObjects, not(hasItem(this)));
		testObjects.add(this);

		assertThat(contextObject, either(is(nullValue())).or(is(contextObject))); //either(().or())는 둘 중 어떤 것을 만족해도 true
		contextObject = this.context;
	}
}
